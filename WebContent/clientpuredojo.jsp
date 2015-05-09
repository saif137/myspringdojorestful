<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<script>dojoConfig = {parseOnLoad: true}</script>
<script src="dojo/dojo.js" ></script>

<script>
dojo.require("dojo.dom");
dojo.require("dojo.dom-construct");
dojo.require("dijit.form.Form");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.ValidationTextBox");
</script>

</head>
<body>
	<h1>REST Web Service Query Interface Using Dojo</h1>
	<div data-dojo-type="dijit/form/Button">
	        Get all user information
	        <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
            dojo.xhrGet({
                // The target URL on your webserver:
                url: "http://localhost:8137/jsonweb/userinfo/getAll",

                // The form node, which contains the to be transferred form elements:
                //form: "myForm",

                // The used data format.  We use JSON.
                handleAs: "json",

                // Timeout in milliseconds:
                timeout: 5000,

                // Event handler on successful call:
                load: function(response, ioArgs, domConstruct){
		  		domConstruct.empty("getAlldiv");
		  		domConstruct.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getAlldiv");
                return response;
            },

                // Event handler on errors:
                error: function(response, ioArgs){
                    console.log("Error xhr: " + response + " : " + ioArgs);

                    // return the response for succeeding callbacks
                    return response;
                }
            });
        </script>
	    </div>
		<div id="getAlldiv"></div>
</body>
</html>