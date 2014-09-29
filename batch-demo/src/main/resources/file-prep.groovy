// use the shell (made available under variable fsh)

if (fsh.test(inputDir)) {
   fsh.rmr(inputDir)
}
fsh.mkdir(inputDir); 
fsh.copyFromLocal(localFile, inputDir); 
fsh.chmod(700, inputDir)
if (fsh.test(outputDir)) {
   fsh.rmr(outputDir)
}
