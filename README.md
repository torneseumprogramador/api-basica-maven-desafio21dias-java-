# Crud criado no desafio 21 dias de Java


# deploy
```shell
####### aws seuservidor #######
usuario: admin
senha: a2d3m4o5i1n1
host: desafiojava.seuservidor.amazonaws.com
database: desafio21diasjava

MYSQL_HOST="desafiojava.seuservidor.amazonaws.com"
MYSQL_DATABASE="desafio21diasjava"
MYSQL_USER="admin"
MYSQL_PASSWORD="a2d3m4o5i1n1"

mysql -u'admin' -p'a2d3m4o5i1n1' -h'desafiojava.seuservidor.amazonaws.com'
mysql> show databases;
mysql> create database desafio21diasjava;
mysql> show databases;

####### azure seuservidor #######
usuario: desafioadmin@desafiojava
senha: a5i1n12d3m&4o
host: desafiojava.banco-de-dados.azure.com
database: desafio21diasjava

MYSQL_HOST="desafiojava.banco-de-dados.azure.com"
MYSQL_DATABASE="desafio21diasjava"
MYSQL_USER="desafioadmin@desafiojava"
MYSQL_PASSWORD="a5i1n12d3m&4o"


mysql -u'desafioadmin@desafiojava' -p'a5i1n12d3m&4o' -h'desafiojava.banco-de-dados.azure.com'
mysql> create database desafio21diasjava;
mysql> show databases;
mysql> create database desafio21diasjava;
mysql> show databases;

```

# Apache server site complete app
``` shell
apt install apache2
a2enmod proxy
a2enmod proxy_http

vim /etc/apache2/sites-available/000-default.conf

### dentro do arquivo ###
<VirtualHost *:80>
        ProxyPreserveHost On

        ProxyPass / http://localhost:8080/
        ProxyPassReverse / http://localhost:8080/
</VirtualHost>
```


# Apache api app
``` shell
apt install apache2

vim /etc/apache2/sites-available/000-default.conf

### dentro do arquivo ###
<VirtualHost *:80>
        ServerAdmin webmaster@localhost
        DocumentRoot /var/www/html

        ErrorLog ${APACHE_LOG_DIR}/error.log
        CustomLog ${APACHE_LOG_DIR}/access.log combined
</VirtualHost>

```