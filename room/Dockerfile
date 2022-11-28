FROM node:16-alpine
WORKDIR /app
COPY package*.json /app
RUN yarn
COPY . .
RUN yarn build
CMD [ "yarn", "start" ]
EXPOSE 3000
