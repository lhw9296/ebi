const path = require('path');
module.exports = {
  devServer: {
    proxy: {
        '/api': {
            target: "http://localhost:9000",  // proxy 서버에 대한 Data
            pathRewrite: { // api로 시작하는 문자를 변환하는 작업
                '^/api': ''
            }
        }
    }
},
configureWebpack: {
  resolve: {
      alias: {
          '~': path.join(__dirname, '/src')
      }
  }
},

  transpileDependencies: [
    'vuetify'
  ]
}

