function add_fields() {
	var table = document.getElementById('propsview');
	var rowCount = table.getElementsByTagName('tbody')[0].rows.length;
	var row = table.insertRow(-1);
	var rowId = 'Row' + rowCount;
	row.id = rowId;
	row.setAttribute ('style', 'visibility:inherit;');
	var dbColumns = [__FIELDS__];
	for (var i = 0; i < dbColumns.length; i++) {
		var cellContent = null;
		if (i == 0) {
			cellContent = document.createElement('select');
			var options = [__OPTIONS__];
			for (var j = 0; j < options.length; j++) {
				var opt = document.createElement('option');
				opt.text = options[j][1];
				opt.value = options[j][0];
				cellContent.appendChild(opt);
			} /* for options */
		} /* if */
		else {
			cellContent = document.createElement('textarea');
		} /* else */
		/* <textarea name="Row'+rowCount+'.LOCATORTYPE"
		// placeholder="LOCATORTYPE" id="Row'+rowCount+'.LOCATORTYPE"
		// style="resize: none; width:100%;"></textarea> */
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
	popupDiv.setAttribute ('style', 'visibility:hidden;');
	popupDiv.setAttribute ('rowid', rowId);
	var divCloseX = document.createElement('button');
	divCloseX.appendChild(document.createTextNode("CloseME"));
	cellPopupDiv.appendChild(popupDiv);
	
}

function showMoreProps(e){
	var id = e.getAttribute('rowid');
	var idPopup = id+'.popupDiv';
	document.getElementById(id).style.visibility = 'visible';
	document.getElementById(idPopup).style.visibility = 'visible';
	document.getElementById('formMainDiv').style.visibility = 'hidden';
}


/*function show(target) {
document.getElementById('parent').style.visibility = 'hidden';
document.getElementById('modalParent').style.visibility = 'visible';
document.getElementById(target).style.visibility = 'visible';
document.getElementById('parent').style.zindex = -1; 
}function hide(target) {
document.getElementById('parent').style.visibility = 'visible';
document.getElementById('modalParent').style.visibility = 'inherit';

document.getElementById(target).style.visibility = 'hidden';
}*/
