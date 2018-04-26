set projloc=C:\\Users\\IBM_ADMIN\\workspace224\\PwotRegressionSuite

cd %projloc%

set classpath=%projloc%\\bin;%projloc%\\JarFiles\\*

java org.testng.TestNG %projloc%\\src\\testng.xml

