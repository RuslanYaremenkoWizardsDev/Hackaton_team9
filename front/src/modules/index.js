import validation from './auth/validation';
import getFetch from './helpers/getFetch';
import urls from './helpers/urls';
import {
  message, translateTour, tourPlacholder,
  regTranslate, authTranslate, authIpt, regIpt, translateStats,
  createIpt, createText
} from './helpers/constants';
import { support } from './helpers/support';
import { login, registration } from './auth/auth';
import renderModal from './mainPage/renderModal';
import renderDeleteModal from './mainPage/renderModal';
import { modal } from './helpers/modal';
import { modalDelete } from './helpers/modal';
import translateAuth from './auth/translateAuth';


export {
  validation, getFetch, login, registration, renderModal, renderDeleteModal, translateAuth
};

export {
  urls, message, support, modal, modalDelete, translateTour,
  tourPlacholder, regTranslate, authTranslate, authIpt, regIpt,
  translateStats, createIpt, createText
};
