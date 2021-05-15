const { Schema, model } = require('mongoose');
const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');

const schema = new Schema({
  login: {
    type: String,
    required: true,
    unique: true
  },
  password: {
    type: String,
    required: true
  },
  person: [{ type: Schema.Types.ObjectId, ref: 'Person' }]
}, { collection: 'users' });
const UserSchema = model('User', schema);
class User {
  static async сonnect() {
    const url = 'mongodb://localhost:27017/project3';
    await mongoose.connect(url, {
      useNewUrlParser: true,
      useFindAndModify: false,
      useUnifiedTopology: true,
      useCreateIndex: true
    });
  }


  login = async (req, res) => {
    const { login, password } = req.body;
    try {


      const user = await UserSchema.findOne({ login });
      if (!user) {
        return this.#setResponse(res, 400, 'ok');
      };

      const isMatch = await bcrypt.compare(password, user.password);
      if (!isMatch) {
        return this.#setResponse(res, 400, 'no');
      }

      const token = jwt.sign(
        { userId: user.id },
        'sadsdadasdasd',
        { expiresIn: '10h' }
      );

      res.json({ token, userId: user.id });
    }
    catch (e) {
      this.#setResponse(res, 400, 'no');
    }
  }

  registration = async (req, res) => {
    const { login, password } = req.body;
    try {

      const candidate = await UserSchema.findOne({ login });
      if (candidate) {
        return this.#setResponse(res, 400, message.userAlreadyReg);
      };

      const hashedPassword = await bcrypt.hash(password, 12);
      const user = new UserSchema({ login, password: hashedPassword });
      await user.save();
      this.#setResponse(res, 201, 'ok');
    }
    catch (e) {
      this.#setResponse(res, 400, 'ne ok');
    }
  }


  setting = async (req, res) => {
    try {
      const user = await UserSchema.findById({ _id: req.user.userId });
      if (req.body.field === 'password') {
        const hashedPassword = await bcrypt.hash(req.body.update, 12);
        user[req.body.field] = hashedPassword;
        await user.save();
        return this.#setResponse(res, 200, 'ok');
      }
      user[req.body.field] = req.body.update;
      await user.save();
      this.#setResponse(res, 200, 'ok');
    }
    catch (e) {
      this.#setResponse(res, 400, 'ne ok');
    }
  }

  #setResponse = (res, status, message) => {
    return res.status(status).json({
      message
    });
  }
}

module.exports = { UserSchema, User };