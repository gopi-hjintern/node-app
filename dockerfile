# Use the official Node.js image from the Docker Hub, based on Alpine Linux
FROM node:22-alpine3.19

# Copy all files from the current directory to the working directory in the container
COPY . .

# Install the dependencies specified in package.json
RUN npm install

# Specify the command to run the application
ENTRYPOINT [ "node","app.js" ]