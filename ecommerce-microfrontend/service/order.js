export default {
    place: (orderId, items) =>
        Promise.resolve(console.log('Placing order', orderId, items))
}