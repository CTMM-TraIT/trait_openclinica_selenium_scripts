/*
Script to generate a random Study subject ID based in the format:
YYYYMMDD-NNNNN

where NNNNN is a random alphabetic string with length 6
and YYYYMMDD is the current date
Usage in Selenium:
-----------           ---------   ----------
createSubjectID                          x
type                    value_to_enter       ${x}
*/

Selenium.prototype.doCreateSubjectID = function( options, varName ) {
	var d = new Date();     
	var curr_date = addLeadingZero(d.getDate());     
	var curr_month = addLeadingZero(d.getMonth() + 1); 
	var curr_year = d.getFullYear();   
	var curr_hour = addLeadingZero(d.getHours()); 
	var curr_min = addLeadingZero(d.getMinutes());;
	var curr_sec = addLeadingZero(d.getSeconds());
    storedVars[ varName ] = curr_year.toString() + curr_month + curr_date  + "-" + curr_hour + ":" +  curr_min + ":" + curr_sec + "-" + randomAlpha(6);    
};


function addLeadingZero( value ) {
	return value < 10 ? "0" + value : "" + value;
}

function randomAlpha ( length ) {
    var alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split( '' );
    return generateRandomString( length, alpha );
}


function generateRandomString( length, chars ) {
    var string = '';
    for ( var i = 0 ; i < length ; i++ )
        string += chars[ Math.floor( Math.random() * chars.length ) ];
    return string;
}