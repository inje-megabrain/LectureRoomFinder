FROM node:18-alpine
RUN npm -g install serve
RUN mkdir /app
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . /app
RUN npm run build
EXPOSE 3000
CMD [ "npm", "start" ]
