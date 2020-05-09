export default {
    inStock: productIds => 
        fetch('/data/warehouse/stock.json')
            .then(b => b.json())
            .catch(console.error)
}