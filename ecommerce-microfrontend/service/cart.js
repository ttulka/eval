export default {
    items: () => 
        fetch('/data/cart/items.json')
            .then(b => b.json())
            .catch(console.error),
    
    addItem: ({productId, title, price, quantity}) => 
        Promise.resolve(console.log('Adding item into cart', productId, title, price, quantity)),
    
    empty: () => Promise.resolve(console.log('Emptying cart')),
}