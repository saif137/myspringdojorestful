<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Client Using Dojo with Servlet Controller</title>
	<link rel="stylesheet" href="style.css" media="screen">
	<link rel="stylesheet" href="demo.css" media="screen">
    <link rel="stylesheet" href="dijit/themes/soria/soria.css" media="screen">    
</head>

<body class="soria">

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
		domConst.place("<p>Requesting all users information </p>", "getall");
		
		xhr("http://localhost:8137/jsonweb/ServletController?op=getallusers", {
		  handleAs: "json"
		}).then(function(data){
		  domConst.empty("getall");
		  //domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getall");
		  domConst.place("<p>response: <code> <br>" + JSON.stringify(data) + "</code></p>", "getall");
		}, function(err){
				console.log("Error xhr: " + err);
		}
		);
	  });
	});
	</script>

	<script>
	require(["dojo/string", "dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
	function(string, xhr, dom, domConst, JSON, on){
	  on(dom.byId("search"), "click", function(){

		if(!(dom.byId("userName").value.length == 0) && !(dom.byId("email").value.length == 0))
		{
			console.log("Both username and email provided");	
			//domConst.place("<p>Requesting user information using both user name and email </p>", "searchresult");

			console.log("http://localhost:8137/jsonweb/ServletController?op=getbyboth&userName="+dom.byId("userName").value+"&email="+dom.byId("email").value);			
			xhr("http://localhost:8137/jsonweb/ServletController?op=getbyboth&userName="+dom.byId("userName").value+"&email="+dom.byId("email").value, {
			  handleAs: "json"
			}).then(function(data){
			  domConst.empty("searchresult");
			  domConst.place("<p>response: <code> <br>" + JSON.stringify(data) + "</code></p>", "searchresult");
			}, function(err){
					console.log("Error xhr: " + err);
			}
			);

		}
		else if(!(dom.byId("userName").value.length == 0)){
				
			console.log("Searching by username");	
			//domConst.place("<p>Requesting user information using user name </p>", "searchresult");
			
			xhr("http://localhost:8137/jsonweb/ServletController?op=getbyusername&userName="+dom.byId("userName").value, {
			  handleAs: "json"
			}).then(function(data){
			  domConst.empty("searchresult");
			  domConst.place("<p>response: <code> <br>" + JSON.stringify(data) + "</code></p>", "searchresult");
			}, function(err){
					console.log("Error xhr: " + err);
			}
			);

	  }
	  else if(!(dom.byId("email").value.length == 0))
	  {
			console.log("Searching by email");	
			//domConst.place("<p>Requesting user information using email </p>", "searchresult");
			
			xhr("http://localhost:8137/jsonweb/ServletController?op=getbyemail&email="+dom.byId("email").value, {
			  handleAs: "json"
			}).then(function(data){
			  domConst.empty("searchresult");
			  domConst.place("<p>response: <code> <br>" + JSON.stringify(data) + "</code></p>", "searchresult");
			}, function(err){
					console.log("Error xhr: " + err);
			}
			);

	  }
	}
	);
	});
	</script>

<div class="demoLayout" style="height: 786px; width: 1024px" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="design: 'headline'">
			<div class="demoLayout" style="height: 10%" data-dojo-type="dijit.layout.BorderContainer" data-dojo-props="region: 'top', splitter: true, design: 'headline'">
				<div id="wsqi" align="center" class="centerPanel" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'center'">
					<h1>Servlet Query Interface Using Dojo</h1>
				</div>
			</div>

			<div class="centerPanel" style="height: 90%; width: 100%" data-dojo-type="dijit.layout.ContentPane" data-dojo-props="region: 'center'">

			<form>
			
			<h2>All users information</h2>
			<button type="button" id="getallbutton">Get all user information</button>
			<div id="getall"></div>
			
			<h2>Searching by User Name</h2>
			<label>User Name</label>
			<input type="text" value="" id="userName" autocomplete="off" name="userName">
			
			<h2>Searching by email</h2>
			<label>Email</label>
			<input type="text" value="" id="email" autocomplete="off" name="email">
			<br>
			<br>
			<button type="button" id="search">Search</button>
			<br>
			<br>
			<div id="searchresult"></div>
			
			</form>
			</div>
</div>

<script>
	require(["dojo/parser"
	         , "dijit/layout/BorderContainer"
	         , "dijit/layout/TabContainer"
	         , "dijit/layout/ContentPane"
	         , "dijit/form/Button"
	         , "dijit/form/DropDownButton"
	         , "dijit/TooltipDialog"
	         , "dijit/form/TextBox"
	         , "dojo/domReady!"], 
	function(parser){
		parser.parse();
	});
	</script>

</body>