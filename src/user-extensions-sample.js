Selenium.prototype.doLoadCustomVariables = function() {
	storedVars["userID"] = "change-me";
	storedVars["userPWD"] = "change-me";
}


Selenium.prototype.doStartLap = function() {
	storedVars["startTime"] = new Date();
}

Selenium.prototype.doLapAndLog = function(message) {
	var endTime = new Date();
	var duration = endTime.getTime() - storedVars["startTime"].getTime();
	message = message.split(' ').join('_');
	var output = "Result of test run: " + "[" + message + "] completed at: " + endTime + ". _Duration " + duration + " ms "; 
	this.doEcho(output);
	this.doStartLap();
}