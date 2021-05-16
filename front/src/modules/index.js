import validation from './auth/validation';
import getFetch from './helpers/getFetch';
import urls from './helpers/urls';
import { message } from './helpers/constants';
import { support } from './helpers/support';
import { login, registration } from './auth/auth';
import renderModal from './mainPage/renderModal';
import renderDeleteModal from './mainPage/renderModal';
import { modal } from './helpers/modal';
import { modalDelete } from './helpers/modal';


export {
  validation, getFetch, login, registration,renderModal, renderDeleteModal
};

export {
  urls, message, support,modal, modalDelete
};

