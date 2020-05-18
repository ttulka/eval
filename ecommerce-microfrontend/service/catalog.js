export default {
    products: () => 
        fetch('/data/catalog/products.json')
            .then(b => b.json())
            .catch(console.error),
        
    productsFromCategory: uri => 
        fetch(`/data/catalog/products-${uri}.json`)
            .then(b => b.json())
            .catch(console.error),

    categories: () =>
    	fetch('/data/catalog/categories.json')
            .then(b => b.json())
}
