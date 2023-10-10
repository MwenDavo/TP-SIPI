const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
    username: String,
    password: String,
    // Otros campos que puedas necesitar
});

const User = mongoose.model('User', userSchema);

module.exports = User;
