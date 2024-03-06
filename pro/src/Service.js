import axios from 'axios';


const getburl="http://localhost:8083/product";

class Service{
    getProduct(){
        return axios.get("http://localhost:8083/product");
    }
    
    
    createProduct(image,itemname,homemakername,price,avail){
        return axios.post("http://localhost:8083/product/in",
        {
            image:image,
            itemname:itemname,
            homemakername:homemakername,
            price:price,
            availability:avail
        },
        {
            headers:
            {
                "Content-Type":'multipart/form-data'
            }
        })
    }

    getProductById(productId){
        return axios.get(getburl + '/get/' + productId);
    }

    updateProduct(id,image,itemname,homemakername,price,availability){
        return axios.put("http://localhost:8083/product/"+id,
        {
            image:image,
            itemname:itemname,
            homemakername:homemakername,
            price:price,
            availability:availability
        },
        {
            headers:
            {
                "Content-Type":'multipart/form-data'
            }
        })
    }

    deleteProduct(productId){
        return axios.delete(getburl + '/' + productId);
    }
}
export default new Service();
