--- /Users/julianmaurel/Desktop/test/restoreOnBeforeInit.js	Fri Jan  4 15:07:40 2019
+++ /Users/julianmaurel/Documents/GitHub/jelastic-package-dev/dx7211/backup/scripts/restoreOnBeforeInit.js	Mon Nov 12 10:10:00 2018
@@ -1,6 +1,6 @@
 //@auth
 
-var baseUrl = "https://raw.githubusercontent.com/jelastic-jps/jahia/master/";
+var baseUrl = "https://raw.githubusercontent.com/Jahia/jelastic-package-dev/master/dx7211/backup";
 
 var storage = use("scripts/useStorageApi.js");
 var userData = storage.getUserData();
@@ -35,9 +35,17 @@
             "dependsOn": "targetRegion"
         }, {
             "caption": "Target region",
-            "type": "regionlist",
+            "type": "string",
             "name": "targetRegion",
-            "selectFirstAvailable": true
+            "default": "jelastic_default_hw_group"
+        }, {
+            "caption": "Root Password",
+            "type": "string",
+            "name": "rootPwd",
+        }, {
+            "caption": "Tools password",
+            "type": "string",
+            "name": "toolsPwd",
         }]
     }
 });
