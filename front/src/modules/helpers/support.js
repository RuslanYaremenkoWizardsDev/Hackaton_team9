export const support = {
  lsSet: (name, item) => localStorage.setItem(name, item),
  lsGet: (name) => localStorage.getItem(name),
  getDate: (d)=>{
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
  
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
  
    return `${year}-${month}-${day}`;
  }
};

