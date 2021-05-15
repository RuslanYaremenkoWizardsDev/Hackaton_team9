export const support = {
  lsSet: (name, item) => localStorage.setItem(name, item),
  lsGet: (name) => localStorage.getItem(name)
};