(function(window, undefined) {
  var dictionary = {
    "09009fda-2933-4a21-9d7b-7197198ba7e6": "viewApplication",
    "760c6c33-0922-4034-9a5c-73568ae9a01f": "editApplication",
    "6034a26e-5928-408e-a960-156e0fbfae9e": "addTask",
    "39db3f06-e8ca-4ef9-ac31-30468ba71f00": "All Tasks",
    "4bc714c1-7260-4c06-9854-9cb4fd7ff93c": "addApplication",
    "83ec270b-774e-4c52-b704-1ae339697430": "ApplicationTasks with Completed",
    "8b128b3b-777b-412c-8975-19d634643e39": "ApplicationTasks with no Completed",
    "9c016c51-5601-4686-83be-3a53345f9b0c": "applicationsSelectScreen",
    "ca8d56d1-704e-403e-9860-f82d780b52f0": "editTask",
    "2f0cc3d5-c8cf-469a-ba89-1b1eb30f6fc7": "applicationFilterbyCompany",
    "d12245cc-1680-458d-89dd-4f0d7fb22724": "Home/Applications",
    "4c74555c-07a8-4205-8abf-abc4076b724b": "viewTask",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);