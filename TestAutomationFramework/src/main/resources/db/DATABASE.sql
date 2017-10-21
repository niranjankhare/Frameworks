use automation;

create table PAGES (
`PAGENAME` VARCHAR (50), -- SELECT
`PARENTID` VARCHAR (50), -- SELECT
`PAGEDESCRIPTION` VARCHAR (150), -- SELECT
PRIMARY KEY (`PAGENAME`)
);

create table GUIMAP (
`GUIMAPID` int (10) NOT NULL AUTO_INCREMENT,
`PAGENAME` VARCHAR (50) NOT NULL, 
`ELEMENTTYPE` VARCHAR (50), -- SELECT (This is user friendly name for user)
`CONTROLNAME` VARCHAR (50), -- SELECT 
`CONTROLDESCRIPTION` VARCHAR (150), -- SELECT 
`FIELDNAME` VARCHAR (150), -- GEnerated from type+name
 PRIMARY KEY (`GUIMAPID`),
 CONSTRAINT fk_page FOREIGN KEY (`PAGENAME`)
 REFERENCES PAGES(`PAGENAME`) 
 ON DELETE CASCADE
 ON UPDATE CASCADE
 );



create table PROPERTIES (
`PROPERTYID` int (10) NOT NULL AUTO_INCREMENT,
`GUIMAPID` int (10) NOT NULL, 
`STANDARDCLASS`  VARCHAR (50), -- same as element type from guimap
`MAPPEDCLASS`  VARCHAR (50), 
`LOCATORVALUE` int (10) NOT NULL, -- Select
`LOCATORTYPE` int (10) NOT NULL, -- Calculate based on value (xpath or id?)
PRIMARY KEY (`PROPERTYID`),
CONSTRAINT fk_guimap FOREIGN KEY (GUIMAPID)
  REFERENCES GUIMAP(`GUIMAPID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

create table TYPES (
`CLASSID` int (10) NOT NULL AUTO_INCREMENT,
`CLASS` VARCHAR (20) NOT NULL,
`TYPE` VARCHAR (20) NOT NULL, 
`ABRV` VARCHAR (10) NOT NULL, 
`TABLEREF`  VARCHAR (50), -- same as element type from guimap
PRIMARY KEY (`CLASSID`)
);




insert into TYPES (`CLASS`, `TYPE`, `ABRV`)
values ('InputText','STANDARD','iTxt'),('Select','STANDARD','sel');


CREATE VIEW automation.entryform AS
SELECT a.ELEMENTTYPE,a.CONTROLNAME, a.CONTROLDESCRIPTION,
b.LOCATORVALUE 
FROM
automation.GUIMAP a, automation.PROPERTIES b;


ALTER TABLE PROPERTIES
DROP FOREIGN KEY fk_guimap;
ALTER TABLE GUIMAP
DROP FOREIGN KEY fk_page;

/*
delimiter //
CREATE TRIGGER updateElements AFTER INSERT ON GUIMAP
FOR EACH ROW 
BEGIN 
INSERT INTO PROPERTIES  VALUES (new.idemployee.40);
   END//;
delimiter ;


INSERT INTO PAGES
SET `pagename` = 'logon',
`parentid` = null,
`pagedescription` = "login page";

*/




