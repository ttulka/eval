export default {
    all: () => 
        fetch('/data/catalog/products.json')
            .then(b => b.json())
            .catch(console.error),
        
    fromCategory: uri => 
        fetch('/data/catalog/products-category.json')
            .then(b => b.json())
            .catch(console.error),

    categories: () =>
    	fetch('/data/catalog/categories.json')
            .then(b => b.json())
}
