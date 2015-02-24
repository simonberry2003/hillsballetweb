ADMIN_DIR=hbsadmin
cp target/HillsBalletSchool.war ../$ADMIN_DIR/webapps/ROOT.war
cd ../$ADMIN_DIR
git add .
git commit -m "Deploying latest version"
git push
