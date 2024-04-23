# Seting up the Raspberry Py
Last Updated 20240413

This notes have the purpose of being an small set of steps to install and run the raspberry py and docker.In this note you're going to find how to configure the Raspberry.

1. Choose the operating system you want to use in the imager: [imager](https://www.raspberrypi.com/software/) 
1. Change the hostname to one that is not for default.
1. Change the pi user from the one that cames from default.
	1. Connect as a root and change user to another different.
1. Disable the autologin for the root.
1. Eneable the SSH conection.
1. Create the public and private key so you can avoid to add the password.

# Useful conmands
## Connect to your raspberry by ssh

```
ssh nameoftheuser@location -> Ej: jino@myraspberryhome
```

## If you want to know since when the server is up
```
uptime -> Since when your server is up
w - Users connected to your server and since when is up

```

## Change and set an static IP

modify /etc/dhcpcd.conf

- interface wlan0 or eth0
- static ip_address=
- static routers=
- static domain_name_servers=
