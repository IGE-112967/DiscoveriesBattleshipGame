# Usa uma imagem oficial base do Ubuntu (focada em desenvolvimento de containers)
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Evita perguntas interativas durante as instalações
ENV DEBIAN_FRONTEND=noninteractive

# Atualiza o sistema e instala o OpenJDK (Java 17 - padrão moderno para Engenharia de Software)
# Instala também o Maven, Git e utilitários essenciais
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
    git \
    curl \
    unzip \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Garante que as variáveis de ambiente do Java estão bem configuradas
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Comando padrão ao iniciar (mantém o container vivo)
CMD ["sleep", "infinity"]