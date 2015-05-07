<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Client Using Dojo</title>
</head>
    <h1 id="wsqi">Web Service Query Interface</h1>
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
	  on(dom.byId("getwsxhr"), "click", function(){
		domConst.place("<p>Requesting http://localhost:8137/jsonweb/greeting using xhr ...</p>", "getwsxhroutput");
		xhr("http://localhost:8137/jsonweb/greeting", {
		  handleAs: "json"
		}).then(function(data){
		  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getwsxhroutput");
		}, function(err){
				console.log("Error xhr: " + err);
		}
		);
	  });
	});
	</script>
	
	<script>
		require(["dojo/request/script", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
		function(script, dom, domConst, JSON, on){
		  on(dom.byId("getws"), "click", function(){
			domConst.place("<p>Requesting http://localhost:8137/jsonweb/greeting ...</p>", "getwsoutput");
			script.get("http://localhost:8137/jsonweb/greeting", {json: "callback"}).then(function(data){	
			  domConst.place("<p>response data: <code>" + dojo.fromJson(data, true) + "</code></p>", "getwsoutput");
			  console.log("Data: " + data);
			}, function(err){
				console.log("Error jsonp: " + err);
			}
			);
		  });
		});
	</script>

	<!-- script>
		require(["dojo/request/xhr", "dojo/dom", "dojo/dom-construct", "dojo/json", "dojo/on", "dojo/domReady!"],
		function(xhr, dom, domConst, JSON, on){
		  on(dom.byId("getws"), "click", function(){
			domConst.place("<p>Requesting...</p>", "getwsoutput");
			xhr("http://localhost:8137/jsonweb/greeting", {
			  handleAs: "json"
			}).then(function(data){
			  domConst.place("<p>response: <code>" + JSON.stringify(data) + "</code></p>", "getwsoutput");
			});
		  });
		});
	</script -->
	
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
	function searchGoogle(){
	   // Look up the node we'll stick the text under.
	   var targetNode = dojo.byId("getwsio");

	   // The parameters to pass to xhrGet, the url, how to handle it, and the callbacks.
	   var jsonpArgs = {
		 url: "http://localhost:8137/jsonweb/greeting",
		 callbackParamName: "callback",
		 content: {
		   v: "1.0",
		   q: "dojo toolkit"
		 },
		 load: function(data){
		   // Set the data from the search into the viewbox in nicely formatted JSON
		   targetNode.innerHTML = "<pre>" + dojo.toJson(data, true) + "</pre>";
		 },
		 error: function(error){
		   targetNode.innerHTML = "An unexpected error occurred: " + error;
		 }
	   };
	   dojo.io.script.get(jsonpArgs);
	 }
	 dojo.ready(searchGoogle);
	</script>
	
	
<body class="claro">

<h1>My Web Service xhr Output:</h1>
<div id="getwsxhroutput"></div>
<button type="button" id="getwsxhr">Get Web Service xhr Output</button>

<h1>My Web Service Output:</h1>
<div id="getwsoutput"></div>
<button type="button" id="getws">Get Web Service Output</button>

<h1>My Web Service io script Output:</h1>
<div id="getwsiooutput"></div>
<button type="button" id="getwsio">Get Web Service Output</button>

<h1>Dojo Pulls Output:</h1>
<div id="getdojopulloutput"></div>
<button type="button" id="getdojopull">Get Dojo Pulls</button>

</body>