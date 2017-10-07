create table PAGES (
`PAGEID` int (10) NOT NULL AUTO_INCREMENT,
`PAGENAME` VARCHAR (50),
`PARENTID` VARCHAR (50), 
`PAGEDESCRIPTION` VARCHAR (150),
PRIMARY KEY (`PAGEID`)
);

create table GUIMAP (
`GUIMAPID` int (10) NOT NULL AUTO_INCREMENT,
`PAGEID` int (10) NOT NULL, 
`ELEMENTTYPE` VARCHAR (50),
`CONTROLNAME` VARCHAR (50), 
`CONTROLDESCRIPTION` VARCHAR (150),
`FIELDNAME` VARCHAR (150),
 PRIMARY KEY (`GUIMAPID`),
 CONSTRAINT fk_page FOREIGN KEY (PAGEID)
 REFERENCES PAGES(`PAGEID`)
 );



create table PROPERTIES (
`PROPERTYID` int (10) NOT NULL AUTO_INCREMENT,
`GUIMAPID` int (10) NOT NULL, 
`STANDARDCLASS`  VARCHAR (50), -- same as element type from guimap
`MAPPEDCLASS`  VARCHAR (50),
`LOCATORSTRATEGY` int (10) NOT NULL,
`TAG` VARCHAR (50),
`ATTRIBUTE` VARCHAR (50),
`VALUE` VARCHAR (50),
PRIMARY KEY (`PROPERTYID`),
CONSTRAINT fk_guimap FOREIGN KEY (GUIMAPID)
  REFERENCES GUIMAP(`GUIMAPID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

/* Trigers
*//*
delimiter //
CREATE TRIGGER updateElements AFTER INSERT ON EMPLOYEE
FOR EACH ROW 
BEGIN 
INSERT INTO age  VALUES (new.idemployee.40);
   END//;
delimiter ;
*/



