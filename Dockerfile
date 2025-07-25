FROM markhobson/maven-chrome:jdk-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . /app