import AxiosClient from './AxiosClient'

class CartApi{
    constructor(){
        this.client = new AxiosClient('/api/cart');
    }
    async register(cart){
        return await this.client.post('/register', cart);
    }
    async retrieveByCartList(){
        return await this.client.post('/retrieveByCartList');
    }
    async modify(cart){
        return this.client.put('/modifyCart', cart);
    }
    async remove(spdNo){
        return (await this.client.get('/removeCart', {spdNo}) ).data
    }
    
}
const instance = new CartApi();

export default instance;