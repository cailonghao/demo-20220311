#
wget -O /etc/yum.repos.d/docker-ce.repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
#
yum install docker-ce -y
#
systemctl start docker
#
docker run -d --name redis -p 6379:6379 redis --requirepass "123456"


yum install -y java-1.8.0-openjdk.x86_64

#
wget https://github.com/alibaba/nacos/releases/download/1.4.3/nacos-server-1.4.3.tar.gz