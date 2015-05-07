<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Client Using Dojo</title>
</head>
    <h1 id="wsqi">REST Web Service Query Interface Using Dojo</h1>
    <!-- load Dojo -->
    <script src="dojo/dojo.js" data-dojo-config="async: true"></script>
	
	<script>
        require([
            'dojo/dom',
            'dojo/dom-construct'
        ], function (dom, domConstruct) {
            var greetingNode = dom.byId('wsqi');
            domConstruct.place('<em> Dojo! Oh yes it is working</em>', greetingNode);
        });
    </script>

	<script>
	require(["dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
	function(xhr, dom, domConst, JSON, on){
	  on(dom.byId("getallbutton"), "click", function(){
		domConst.place("<p>Requesting all users information </p>", "getalldiv");
		xhr("http://localhost:8137/jsonweb/userinfo/getAll", {
		  handleAs: "json"
		}).then(function(data){
		  domConst.empty("getalldiv");
		  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getalldiv");
		}, function(err){
				console.log("Error xhr: " + err);
		}
		);
	  });
	});
	</script>

	<script>
	require(["dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
	function(xhr, dom, domConst, JSON, on){
	  on(dom.byId("getbyfnamebutton"), "click", function(){
		domConst.place("<p>Requesting user by first name </p>", "getbyfname");
		xhr("http://localhost:8137/jsonweb/userinfo/getByFname/" + dom.byId("fname").value, {
		  handleAs: "json"
		}).then(function(data){
		  domConst.empty("getbyfname");
		  console.log("text box value" + dom.byId("fname").value);
		  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getbyfname");
		}, function(err){
				console.log("Error xhr: " + err);
		}
		);
	  });
	});
	</script>

	<script>
	require(["dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
	function(xhr, dom, domConst, JSON, on){
	  on(dom.byId("getbylnamebutton"), "click", function(){
		domConst.place("<p>Requesting user by last name </p>", "getbylname");
		xhr("http://localhost:8137/jsonweb/userinfo/getByLname/" + dom.byId("lname").value, {
		  handleAs: "json"
		}).then(function(data){
		  domConst.empty("getbylname");
		  console.log("text box value" + dom.byId("lname").value);
		  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getbylname");
		}, function(err){
				console.log("Error xhr: " + err);
		}
		);
	  });
	});
	</script>

	<script>
	require(["dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
	function(xhr, dom, domConst, JSON, on){
	  on(dom.byId("getbyemailbutton"), "click", function(){
		domConst.place("<p>Requesting user by email </p>", "getbyemail");
		xhr("http://localhost:8137/jsonweb/userinfo/getByEmail/" + dom.byId("email").value, {
		  handleAs: "json"
		}).then(function(data){
		  domConst.empty("getbyemail");
		  console.log("text box value" + dom.byId("email").value);
		  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getbyemail");
		}, function(err){
				console.log("Error xhr: " + err);
		}
		);
	  });
	});
	</script>

	<!--  Validation scripts -->
	<script>
	require(["dojo/dom", "dojo/_base/array", "dojo/_base/event", "dojo/query", "dojox/validate/web", "dojox/validate/us", "dojox/validate/check", "dojo/domReady!"],
			function(dom, arrayUtil, baseEvent, query, validate) {

				function doCheck(form){
					var results = validate.check(form, profile),					
							r = dom.byId("validationmsg");

					if(results.isSuccessful()){
						//	everything passed, log it to the result div
						r.innerHTML = "Everything passed validation!";
					} else {
						var s = "";
						var missing = results.getMissing();
						if(missing.length){
							s += '<h4>The following fields are missing:</h4>'
							+ '<ol>';
							arrayUtil.forEach(missing, function(field){
								s += '<li>' + field + '</li>';
							});
							s += '</ol>';
						}

						var invalid = results.getInvalid();
						if(invalid.length){
							s += '<h4>The following fields are invalid:</h4>'
							+ '<ol>';
							arrayUtil.forEach(invalid, function(field){
								s += '<li>' + field + '</li>';
							});
							s += '</ol>';
						}

						r.innerHTML = s;
					}
				}

				//	wait until after our requires are actually loaded.
				profile = {
					trim: ["fname", "lname", "email"],
					//required: ["fname", "lname", "email"],
					constraints: {
						fname: 	validate.isText,
						lname:  	validate.isText,
						//password:  	validate.isText,
						//password2: 	validate.isText,
						email:		[validate.isEmailAddress, false, true],
						//emailConfirm: [validate.isEmailAddress, false, true],
						//phone:		validate.us.isPhoneNumber
					},
					//confirm: {
					//	"emailConfirm": "email",
					//	"password2": "password"
					//}
				};

				//	set up the form handler.
				var f = query("form")[0];
				f.onsubmit = function(e){
					baseEvent.stop(e);
					doCheck(f);
				};
			});
	</script>
	
	<!--  Below code is for prototyping -->
	<!-- 
	<script>
	require(["dojo/request/script", "dojo/dom-construct", "dojo/dom", "dojo/_base/array",
				"dojo/domReady!"
				], function(script, domConstruct, dom, arrayUtil){
					script.get("http://localhost:8137/jsonweb/userinfo/greeting?callback={callback}", {
						jsonp: "callback"
					}).then(function(response){
						return response.data;
					}).then(function(results){
						// Create a document fragment to keep from
						// doing live DOM manipulation
						var fragment = document.createDocumentFragment();
						arrayUtil.forEach(results, function(pull){
							var li = domConstruct.create("li", {}, fragment);
							var link = domConstruct.create("a", {href: pull.url, innerHTML: pull.title}, li);
						});
						domConstruct.place(fragment, dom.byId("getwsoutput"));
					});
				});
	</script>
		
	<script>
		require(["dojo/request/script", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
		function(script, dom, domConst, JSON, on){
		  
		  on(dom.byId("getdojopull"), "click", function(){
			domConst.place("<p>Requesting...</p>", "getdojopulloutput");
			script.get("https://api.github.com/repos/dojo/dojo/pulls", {
			  jsonp: "callback"
			}).then(function(data){
			  domConst.place("<p>response data: <code>" + JSON.stringify(data) + "</code></p>", "getdojopulloutput");
			});
		  });
		  
		});
	</script>

	<script>
		require(["dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
		function(xhr, dom, domConst, JSON, on){
		  on(dom.byId("getws"), "click", function(){
			domConst.place("<p>Requesting...</p>", "getwsoutput");
			xhr("http://localhost:8137/userinfo/jsonweb/greeting", {
			  handleAs: "json"
			}).then(function(data){
			  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getwsoutput");
			});
		  });
		});
	</script>	
	 -->
	
<body class="claro">

<form>

<h1>All users information</h1>
<div id="getalldiv"></div>
<button type="button" id="getallbutton">Get all user information</button>

<h1>Searching by first name</h1>
<div id="getbyfname"></div>
<label>First name</label>
<input type="text" value="" id="fname" autocomplete="off" name="fname">
<button type="button" id="getbyfnamebutton">Get user by first name</button>

<h1>Searching by last name</h1>
<div id="getbylname"></div>
<label>Last name</label>
<input type="text" value="" id="lname" autocomplete="off" name="lname">
<button type="button" id="getbylnamebutton">Get user by last name</button>

<h1>Searching by email</h1>
<div id="getbyemail"></div>
<label>Last name</label>
<input type="text" value="" id="email" autocomplete="off" name="email">
<button type="button" id="getbyemailbutton">Get user by email</button>
<br>
<br>
<input type="submit" value="Validate fields" />

</form>

<div id="validationmsg"></div>

<!-- This code is for prototyping -->
<!-- 

<h1>My Web Service Output:</h1>
<div id="getwsoutput"></div>
<button type="button" id="getws">Get Web Service Output</button>

<h1>Dojo Pulls Output:</h1>
<div id="getdojopulloutput"></div>
<button type="button" id="getdojopull">Get Dojo Pulls</button>
-->

</body>