function add_fields() {
	var table = document.getElementById('propsview');
	var rowCount = table.getElementsByTagName('tbody')[0].rows.length;
	var row = table.insertRow(-1);
	var rowId = 'Row' + rowCount;
	row.id = rowId;
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
	popupBtn.setAttribute ('onclick','showMoreProps()');
	popupBtn.id = rowId + '.popupBtn';
	popupBtn.appendChild(document.createTextNode("CLICK ME"));
	popupBtn.style.resize = 'none';
	var cell = row.insertCell(-1);
	cell.appendChild(popupBtn);
}

function showMoreProps(){
	window.alert("sometext");
}