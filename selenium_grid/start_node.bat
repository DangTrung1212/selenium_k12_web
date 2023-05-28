ECHO OFF
java -jar -Dwebdriver.chrome.driver="%USERPROFILE%/.cache/selenium/chromedriver/win32/113.0.5672.63/chromedriver.exe" selenium-server-4.8.0.jar node --config node_config.json
