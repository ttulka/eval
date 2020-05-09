export default {
    prepare: (orderId, {name, address}) =>
        Promise.resolve(console.log('Preparing delivery', orderId, name, address))
}