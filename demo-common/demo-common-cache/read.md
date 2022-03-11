#
wget -O /etc/yum.repos.d/docker-ce.repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
#
yum install docker-ce -y
#
systemctl start docker
#
docker run -d --name redis -p 6379:6379 redis --requirepass "123456"