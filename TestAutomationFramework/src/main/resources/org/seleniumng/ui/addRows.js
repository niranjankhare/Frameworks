function add_NewRow(){
add_Row(false);
}


function add_Row(f){
	var table = document.getElementById('propsview');
	var rowCount = table.getElementsByTagName('tbody')[0].rows.length;
	var row =  (table.getElementsByTagName('tbody')[0]).insertRow(-1);
	var rowId = 'Row' + rowCount;
	row.id = rowId;
	row.setAttribute ('style', 'visibility:inherit;');
	var oper = document.getElementById('oper');
	
	var resp = Promise.resolve(getTableFields('propsview'));
	resp.then(function (dbColumns){
		var index = dbColumns.indexOf('CONTROLNAME');
		
		for (var i = 0; i < dbColumns.length; i++) {
			var cellContent = null;
			if (i === dbColumns.indexOf('STANDARDCLASS')) {
				cellContent = document.createElement('select');
				getStandardtypes(cellContent);
			}
			else {
				
				if (i< index){
					/*
					 * cellContent.setAttribute ('style', 'visibility:hidden;');
					 * cellContent.disabled=true;
					 */
					cellContent = document.createElement('input');
					if (!f){
						cellContent.setAttribute ('type', 'hidden');
						cellContent.disabled=true;
					}
				} else
					cellContent = document.createElement('textarea');
			} 
			cellContent.placeholder = dbColumns[i];
			cellContent.name = rowId + '.' + dbColumns[i];
			cellContent.id = cellContent.name;
			cellContent.style.resize = 'none';
			var cell = row.insertCell(-1);
			cell.appendChild(cellContent);
		}
		var popupBtn = document.createElement('button');
		popupBtn.type = 'button';
		popupBtn.setAttribute ('onclick','showMoreProps(this, "'+ oper.value +'")');
		popupBtn.id = rowId + '.popupBtn';
		popupBtn.appendChild(document.createTextNode("Define More\nProperties"));
		popupBtn.style.resize = 'none';
		popupBtn.setAttribute ('rowid', rowId);
		var cellButton = row.insertCell(-1);
		cellButton.appendChild(popupBtn);
		var cellPopupDiv = row.insertCell(-1);
		cellPopupDiv.setAttribute ('style', 'visibility:hidden;');
		var popupDiv = document.createElement('div');
		popupDiv.id = rowId +'.popupDiv';
		popupDiv.setAttribute ('style', 'visibility:hidden;display:block');
		popupDiv.setAttribute ('rowid', rowId);
		cellPopupDiv.appendChild(popupDiv);
	});

}


function add_UpdateRow(){
	var tableName = document.getElementById('tableName').value;
	var pageName = document.getElementById('pageName').value;
	var elTable = document.getElementById(tableName);
	
	var respFields = Promise.resolve(getTableData(tableName, pageName));
	var oper = document.getElementById('oper').value;
	respFields.then(function (tableData){
		var headerRow = document.getElementById('headerRow');
		var dbColumns = tableData[0];
		var indexToHide = dbColumns.indexOf('CONTROLNAME');
		var selectIndex = dbColumns.indexOf('STANDARDCLASS');
		for (var i = 0; i < dbColumns.length; i++) {
			var th = document.createElement('th');
			if (i< indexToHide){
				th.setAttribute ('style', 'display:none;');
			}
            headerRow.appendChild(th).innerHTML=dbColumns[i];
        }
		headerRow.appendChild(document.createElement('th')).innerHTML='More properties';
		
		for (var k = 1; k < tableData.length; k++) {
				
				var rowData = tableData[k];
				var row = (elTable.getElementsByTagName('tbody')[0]).insertRow(-1);
				for (var r=0; r<rowData.length; r++){
					var rowId = 'Row' + (k-1) + '.' + dbColumns[r];
					var cell = row.insertCell(-1);
					var hiddenInput = document.createElement('input');
					if (r< indexToHide){
						cell.setAttribute ('style', 'display:none;');
					} 
					hiddenInput.setAttribute ('name', rowId);
					hiddenInput.id = hiddenInput.name;
					hiddenInput.value = rowData[r];
					cell.appendChild(hiddenInput);
				}
				var popupBtn = document.createElement('button'); 
				popupBtn.type = 'button'; 
				popupBtn.setAttribute
					  ('onclick','showMoreProps(this, "' + oper.value + '")');
				popupBtn.id = rowId +
					  '.popupBtn'; 
				popupBtn.appendChild(document.createTextNode("Define More\nProperties")); 
			  popupBtn.style.resize = 'none';
			  popupBtn.setAttribute ('rowid', rowId); 
			  var cellButton = row.insertCell(-1); 
			  cellButton.appendChild(popupBtn); 
			  var cellPopupDiv = row.insertCell(-1); 
			  cellPopupDiv.setAttribute ('style', 'visibility:hidden;'); 
			  var popupDiv = document.createElement('div'); 
			  popupDiv.id = rowId +'.popupDiv';
			  popupDiv.setAttribute ('style', 'visibility:hidden;display:block'); 
			  popupDiv.setAttribute ('rowid', rowId); 
			  cellPopupDiv.appendChild(popupDiv); 
				
			}
			
			  
			 
		});
	}
/*
 * for (String field : mainFieldsList) {
 * headerRow.appendElement("th").text(field); } var rowCount =
 * elTable.getElementsByTagName('tbody')[0].rows.length; var row =
 * elTable.insertRow(-1); var rowId = 'Row' + rowCount; row.id = rowId;
 * row.setAttribute ('style', 'visibility:inherit;');
 * ==================================================
 * ==================================================
 * 
 * var index = dbColumns.indexOf('CONTROLNAME');
 * 
 * for (var i = 0; i < dbColumns.length; i++) { var cellContent = null; if (i
 * === dbColumns.indexOf('STANDARDCLASS')) { cellContent =
 * document.createElement('select'); getStandardtypes(cellContent); } else {
 * 
 * if (i< index){
 * 
 * cellContent = document.createElement('input'); cellContent.setAttribute
 * ('type', 'hidden'); cellContent.disabled=true; } else cellContent =
 * document.createElement('textarea'); } cellContent.placeholder = dbColumns[i];
 * cellContent.name = rowId + '.' + dbColumns[i]; cellContent.id =
 * cellContent.name; cellContent.style.resize = 'none'; var cell =
 * row.insertCell(-1); cell.appendChild(cellContent); }
 */		

function getStandardtypes(e){
	Promise.resolve(getData('/fetch/libdatabase/getstandardypes'))
	.then(function(resp){
		getSelectControlt(resp, e);
	})
	.catch (function(error){
		return null;
	});
}
/*
 * function getData(u){ const request = async () => { const response = await
 * fetch(u); while (typeof response == 'undefined'){ sleep (1000); } const json =
 * await response.json(); return json; };
 * 
 * return request(); }
 */
async function getData(u){
	let response = await fetch(u);
	return response.json();
}
function getTableFields(tname){
	r = Promise.resolve(getData('/fetch/libdatabase/gettablefields?tableName='+tname)); 
	return r;
}

function getTableData(tname,pname){
	r = Promise.resolve(getData('/fetch/libdatabase/gettabledata?tableName='+tname+"&pageName="+ pname)); 
	return r;
}

function getSelectControl (options){
	var opt = document.createElement('option');
	for (var j = 0; j < options.length; j++) {
		opt.text = options[j][1];
		opt.value = options[j][0];
	} 
	
	return opt;
}

function getSelectControlt (options, element){
	for (var key in options){
		var opt = document.createElement('option');
		opt.text = options[key][0];
		opt.value = key;
		element.appendChild(opt);
	}
}

function showMoreProps(e , op){
	e.disabled = true;
	var rowId = e.getAttribute('rowid');
	var popup = document.getElementById(rowId+'.popupDiv');
	if (!popup.contains(popup.querySelector('div[id=\'popupTitle\']')))
		fillPopup (popup, op);
	popup.style.visibility = 'visible';
	popup.style.display = 'inline';
	showRowById(rowId);
	disableMainForm(op);		
}

function fillPopup(p, op){
	Promise.resolve(getData('/fetch/libdatabase/getcustomtypes'))
	.then(function(resp){
		var title = document.createElement ('div');
		title.setAttribute('id', 'popupTitle');
		title.appendChild(document.createTextNode("Define More\nProperties"));
		title.appendChild (getPopupCloseButtonForRowId(p.getAttribute('rowId'), op));
		p.appendChild(title);
		var content = document.createElement('div');
		content.appendChild(document.createTextNode("Extend to class:"));
		var sel = document.createElement('select');
		sel.name = p.getAttribute('rowId') + '.MAPPEDCLASS';
		getSelectControlt(resp, sel);
		content.appendChild(sel);
		var selKey = sel.options[sel.selectedIndex].value;
		var propsJson = JSON.parse(resp[selKey][1]);
		var exPropsTable = document.createElement('table');
		exPropsTable.setAttribute("id", p.getAttribute('rowId')+'.exPropsTable');
		content.appendChild(exPropsTable);
		
		exPropsTable.appendChild(document.createElement('tbody'));
		var hdrRow = exPropsTable.insertRow(-1);	
		p.appendChild(content);
		addRowToPopup (p, propsJson);
	})
	.catch (function(error){
		
	});
	
}

function showRowById (id){
	var row = document.getElementById(id);
	row.style.visibility = 'visible';

}

function disableMainForm (op){
	disableMainFormButtions(op);
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'hidden';
}

function disableMainFormButtions(op){
	if (op === 'new'){
		document.getElementById('addRow').disabled = true;
	}
	document.getElementById('submit').disabled = true;
}

function getPopupCloseButtonForRowId (rowId, op) {
	var divCloseX = document.createElement('button');
	divCloseX.type = 'button';
	divCloseX.setAttribute ('rowid', rowId);
	divCloseX.setAttribute ('style','background: none; border:none; color:red; cursor:pointer;');
	divCloseX.setAttribute ('onclick','closeMoreProps(this, "'+op+'")');
	divCloseX.appendChild(document.createTextNode("X"));
	return divCloseX;
}

function closeMoreProps(e, op){
	var id = e.getAttribute('rowid');
	var idPopup = id+'.popupDiv';
	document.getElementById(id+'.popupBtn').disabled = false;
	enableMainForm(op);
	resetRowById(id);
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'inherit';
	var row = document.getElementById(id);
	var popup = document.getElementById(idPopup);
	row.style.visibility = 'inherit';
	popup.style.visibility = 'hidden';
	popup.style.display = 'none';
}

function enableMainForm (oper){
	enableMainFormButtions(oper);
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'inherit';
}
function enableMainFormButtions(op){
	
	if (op === 'new'){
		document.getElementById('addRow').disabled = false;
	}
	document.getElementById('submit').disabled = false;
}

function resetRowById (id){
	var row = document.getElementById(id);
	row.style.visibility = 'inherit';

}

function sleep(ms) {
	  return new Promise(resolve => setTimeout(resolve, ms));
}

function addRowToPopup(popup,rowContent){
	var rowId = popup.getAttribute('rowId');
	var tableId = rowId+'.exPropsTable';
	console.log(tableId);
	var pTable = document.getElementById(tableId);
	for (var i in rowContent){
		var row = pTable.insertRow(-1);	
		var displayText = rowContent[i];
		var displayCell = row.insertCell(-1);
		displayCell.innerHTML =displayText;
		row.id = rowId;
		var cellContent = document.createElement('textarea');
		cellContent.placeholder = displayText;
		cellContent.name = rowId + '.' + i;
		cellContent.id = cellContent.name;	
		var valueCell = row.insertCell(-1);
		valueCell.appendChild(cellContent);
	}
	
}

