function add_row(){
	var table = document.getElementById('propsview');
	var rowCount = table.getElementsByTagName('tbody')[0].rows.length;
	var row = table.insertRow(-1);
	var rowId = 'Row' + rowCount;
	row.id = rowId;
	row.setAttribute ('style', 'visibility:inherit;');
	var resp = getTableFields('propsview');
	resp.then(function (dbColumns){
		for (var i = 1; i < dbColumns.length; i++) {
			var cellContent = null;
			if (i == 1) {
				cellContent = document.createElement('select');
				getStandardtypes(cellContent);
			}
			else {
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
		popupBtn.setAttribute ('onclick','showMoreProps(this)');
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
function getStandardtypes(e){
	Promise.resolve(getData('/fetch/libdatabase/getstandardypes'))
	.then(function(resp){
		getSelectControlt(resp, e);
	})
	.catch (function(error){
		return null;
	});
}

function getData(u){
	const request = async () => {
	    const response = await fetch(u);
	    while (typeof response == 'undefined'){
		    sleep (1000);
	    }
	    const json = await response.json();
	    return json;
	};
	
	return request();

}

function getTableFields(tname){
	return Promise.resolve(getData('/fetch/libdatabase/gettablefields?'+tname))
}

function getSelectControl (options){
/*	var control = document.createElement('select');*/
	var opt = document.createElement('option');
	for (var j = 0; j < options.length; j++) {
/*		var opt = document.createElement('option'); */
		opt.text = options[j][1];
		opt.value = options[j][0];
/*		control.appendChild(opt); */
	} 
	
	return opt;
}

function getSelectControlt (options, element){
/*	var control = document.createElement('select');*/
	for (var key in options){
		var opt = document.createElement('option');
		opt.text = options[key][0];
		opt.value = key;
		element.appendChild(opt);
	}
/*	return control;*/
}

function showMoreProps(e){
	e.disabled = true;
	var rowId = e.getAttribute('rowid');
	var popup = document.getElementById(rowId+'.popupDiv');
	if (!popup.contains(popup.querySelector('div[id=\'popupTitle\']')))
		fillPopup (popup);
	popup.style.visibility = 'visible';
	showRowById(rowId);
	disableMainForm();		
}

function fillPopup(p){
	Promise.resolve(getData('/fetch/libdatabase/getcustomtypes'))
	.then(function(resp){
		var title = document.createElement ('div');
		title.setAttribute('id', 'popupTitle');
		title.appendChild(document.createTextNode("Define More\nProperties"));
		title.appendChild (getPopupCloseButtonForRowId(p.getAttribute('rowId')));
		p.appendChild(title);
		var content = document.createElement('div');
		content.appendChild(document.createTextNode("Extend to class:"));
		var sel = document.createElement('select');
		sel.name = p.getAttribute('rowId') + '.MAPPEDCLASS';
		getSelectControlt(resp, sel);
		content.appendChild(sel);
		var selKey = sel.options[sel.selectedIndex].value;
		var props = resp[selKey][1].split(',');
		for (var i=0;i<props.length; i++){
			var prop = props[i].split('=');
			console.log('ColumnName:'+prop[0]);
			console.log ('DisplayName:'+prop[1]);
		}

		p.appendChild(content);
	})
	.catch (function(error){
		
	});
	
	
/*	alert (p.getAttribute('id'));*/
	
}

function showRowById (id){
	var row = document.getElementById(id);
	row.style.visibility = 'visible';

}

function disableMainForm (){
	disableMainFormButtions();
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'hidden';
}

function disableMainFormButtions(){
	document.getElementById('addRow').disabled = true;
	document.getElementById('submit').disabled = true;
}

function getPopupCloseButtonForRowId (rowId) {
	var divCloseX = document.createElement('button');
	divCloseX.type = 'button';
	divCloseX.setAttribute ('rowid', rowId);
	divCloseX.setAttribute ('style','background: none; border:none; color:red; cursor:pointer;');
	divCloseX.setAttribute ('onclick','closeMoreProps(this)');
	divCloseX.appendChild(document.createTextNode("X"));
	return divCloseX;
}

function closeMoreProps(e){
	var id = e.getAttribute('rowid');
	var idPopup = id+'.popupDiv';
	document.getElementById(id+'.popupBtn').disabled = false;
	enableMainForm();
	resetRowById(id);
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'inherit';
	var row = document.getElementById(id);
	var popup = document.getElementById(idPopup);
	row.style.visibility = 'inherit';
	popup.style.visibility = 'hidden';
}

function enableMainForm (){
	enableMainFormButtions();
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'inherit';
}
function enableMainFormButtions(){
	document.getElementById('addRow').disabled = false;
	document.getElementById('submit').disabled = false;
}

function resetRowById (id){
	var row = document.getElementById(id);
	row.style.visibility = 'inherit';

}

function sleep(ms) {
	  return new Promise(resolve => setTimeout(resolve, ms));
}

