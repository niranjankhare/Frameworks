function add_row(){
	var table = document.getElementById('propsview');
	var rowCount = table.getElementsByTagName('tbody')[0].rows.length;
	var row = table.insertRow(-1);
	var rowId = 'Row' + rowCount;
	row.id = rowId;
	row.setAttribute ('style', 'visibility:inherit;');
	var dbColumns = [__FIELDS__];
	var stdClasses = [__OPTIONS__];
	for (var i = 0; i < dbColumns.length; i++) {
		var cellContent = null;
		if (i == 0) {
			cellContent = getSelectControl(stdClasses);
		} /* if */
		else {
			cellContent = document.createElement('textarea');
		} /* else */
		cellContent.placeholder = dbColumns[i];
		cellContent.name = rowId + '.' + dbColumns[i];
		cellContent.id = cellContent.name;
		cellContent.style.resize = 'none';
		var cell = row.insertCell(-1);
		cell.appendChild(cellContent);
	} /* for */
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
	
}

function getSelectControl (options){
	var control = document.createElement('select');
	for (var j = 0; j < options.length; j++) {
		var opt = document.createElement('option');
		opt.text = options[j][1];
		opt.value = options[j][0];
		control.appendChild(opt);
	} /* for options */
	
	return control;
}

function getSelectControlt (options){
	var control = document.createElement('select');
	for (var key in options){
		var opt = document.createElement('option');
		opt.text = options[key];
		opt.value = key;
		control.appendChild(opt);
	}
	
	return control;
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

function getData(u){
	var request = async () => {
	    const response = await fetch(u);
	    json = await response.json();
	    return json;
	};
	return request();

}

function disableMainForm (){
	disableMainFormButtions();
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'hidden';
}

function enableMainForm (){
	enableMainFormButtions();
	var form = document.getElementById('formMainDiv');
	form.style.visibility = 'inherit';
}

function disableMainFormButtions(){
	document.getElementById('addRow').disabled = true;
	document.getElementById('submit').disabled = true;
}

function enableMainFormButtions(){
	document.getElementById('addRow').disabled = false;
	document.getElementById('submit').disabled = false;
}
function showRowById (id){
	var row = document.getElementById(id);
	row.style.visibility = 'visible';

}

function resetRowById (id){
	var row = document.getElementById(id);
	row.style.visibility = 'inherit';

}



function fillPopup(p,content){
	Promise.resolve(getData('/fetch/libdatabase/getcustomtypes'))
	.then(function(resp){
		var title = document.createElement ('div');
		title.setAttribute('id', 'popupTitle');
		title.appendChild(document.createTextNode("Define More\nProperties"));
		title.appendChild (getPopupCloseButtonForRowId(p.getAttribute('rowId')));
		p.appendChild(title);
		var content = document.createElement('div');
		content.appendChild(document.createTextNode("Extend to class:"));
		
		var sel = getSelectControlt(resp);
		content.appendChild(sel);
		
		
		p.appendChild(content);
	})
	.catch (function(error){
		
	});
	/*};*/
	
	alert (p.getAttribute('id'));
	alert(JSON.stringify(content));
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