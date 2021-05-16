export const
  message = {
    invalidLogin: {
      en: 'Login must consist of 6-20 latin characters and numbers',
      ru: 'Логин должен состоять из 6-20 латинcких символов и цифр',
      ar: 'يجب أن يتكون تسجيل الدخول من 6-20 حرفًا وأرقامًا لاتينية ،'
    },
    invalidPass: {
      en: 'Password must consist of 6-14 latin and special characters and numbers',
      ru: 'Пароль должен состоять из 6-14 латинcких и спец символов, и цифр',
      ar: 'يجب أن تتكون كلمة المرور من 6-14 حرفًا وأرقامًا لاتينية وخاصة.'
    },
    invalidRepeatPass: {
      en: 'Password doesn`t match',
      ru: 'Не совпадает пароль',
      ar: 'رمز مرور خاطئ'
    },
  },
  header = {
    tournaments: {
      en: 'Tournaments',
      ru: 'Турниры',
      ar: 'البطولات'
    },
    createTour: {
      en: 'Create tournaments',
      ru: 'Создать турнир',
      ar: 'أنشئ بطولة'
    },
    stats: {
      en: 'Stats',
      ru: 'Статистика',
      ar: 'إحصائيات'
    },
    logOut: {
      en: 'Log Out',
      ru: 'Выйти',
      ar: 'إطفاء'
    },
  },
  translateTour = {
    ...header,
    clearAll: {
      en: 'Clear All',
      ru: 'Удалить все',
      ar: 'امسح الكل'
    },
    searchStart: {
      en: 'Search by start date',
      ru: 'Поиск по дате старта',
      ar: 'البحث حسب تاريخ البدء'
    },
    searchReg: {
      en: 'Search by type',
      ru: 'Поиск по типу',
      ar: 'البحث حسب تاريخ التسجيل'
    },
    searchState: {
      en: 'Search by players',
      ru: 'Поиск по игрокам',
      ar: 'البحث عن طريق الدولة'
    },
    tourName: {
      en: 'Name',
      ru: 'Название',
      ar: 'اسم'
    },
    searchCup: {
      en: 'cup',
      ru: 'кубок',
      ar: 'فنجان '
    },
    tourMode: {
      en: 'Mode',
      ru: 'Режим',
      ar: 'الوضع'
    },
    tourPlace: {
      en: 'Place',
      ru: 'Место',
      ar: 'مكان'
    },
    tourStart: {
      en: 'Start date',
      ru: 'Дата старта',
      ar: 'تاريخ البدء'
    },
    tourReg: {
      en: 'Last reg date',
      ru: 'Конец регистрации',
      ar: 'نهاية التسجيل'
    },
    tourState: {
      en: 'State',
      ru: 'Состояние',
      ar: 'شرط'
    },
    tourLvl: {
      en: 'Level',
      ru: 'Уровень',
      ar: 'مستوى'
    },
    tourPart: {
      en: 'Participants',
      ru: 'Кол-во участников',
      ar: 'مشاركون'
    },
    tourScenario: {
      en: 'Scenario',
      ru: 'Сценарий',
      ar: 'سيناريو'
    },
    tourActions: {
      en: 'Actions',
      ru: 'Действия',
      ar: 'إجراءات'
    }
  },
  tourPlacholder = {
    entStartDate: {
      en: 'Enter start date...',
      ru: 'Введите дату начала...',
      ar: 'أدخل تاريخ البدء'
    },
    entRegDate: {
      en: 'Enter reg date...',
      ru: 'Введите дату регистрации...',
      ar: 'أدخل تاريخ التسجيل'
    },
    entState: {
      en: 'Enter player name...',
      ru: 'Введите имя игрока...',
      ar: 'أدخل بلدك'
    }
  },
  authTranslate = {
    logLabel: {
      en: 'Login',
      ru: 'Логин',
      ar: 'تسجيل الدخول'
    },
    passLabel: {
      en: 'Password',
      ru: 'Пароль',
      ar: 'كلمه السر'
    },
    guest: {
      en: 'Login as a guest',
      ru: 'Войти как гость',
      ar: 'تسجيل الدخول كضيف'
    }
  },
  loginTranslate = {
    ...authTranslate,
    title: {
      en: 'AUTHORIZATION',
      ru: 'Авторизация',
      ar: 'تفويض'
    },
    signUp: {
      en: 'Sign up',
      ru: 'К регистрации',
      ar: 'مشاركة'
    },
    signBtn: {
      en: 'Submit',
      ru: 'Отправить',
      ar: 'إرسال'
    },
  },
  regTranslate = {
    ...authTranslate,
    title: {
      en: 'Registration',
      ru: 'Регистрация',
      ar: 'تسجيل'
    },
    signBtn: {
      en: 'Registrate',
      ru: 'Зарегистрироваться',
      ar: 'تسجيل'
    },
    confirmLabel: {
      en: 'Confirm password',
      ru: 'Подтвердить пароль',
      ar: 'تأكيد كلمة المرور'
    },
    signIn: {
      en: 'Sign in',
      ru: 'К авторизации',
      ar: 'مشاركة'
    },
  },
  authIpt = {
    login: {
      en: 'Enter login...',
      ru: 'Введите логин...',
      ar: 'أدخل تسجيل الدخول'
    },
    password: {
      en: 'Enter password...',
      ru: 'Введите пароль...',
      ar: 'أدخل كلمة المرور'
    },
  },
  regIpt = {
    ...authIpt,
    confirmPassword: {
      en: 'Confirm password...',
      ru: 'Подтвердите пароль...',
      ar: 'تأكيد كلمة المرور'
    }
  },
  translateStats = {
    ...header,
    name: {
      en: 'Name',
      ru: 'Имя',
      ar: 'اسم'
    },
    games: {
      en: 'Games',
      ru: 'Игры',
      ar: 'ألعاب'
    },
    wins: {
      en: 'Wins',
      ru: 'Победы',
      ar: 'يفوز'
    },
    draws: {
      en: 'Draws',
      ru: 'Ничьи',
      ar: 'رسم'
    },
    loses: {
      en: 'Loses',
      ru: 'Поражения',
      ar: 'يخسر'
    },
    cupWins: {
      en: 'Cup Wins',
      ru: 'Побед в кубке',
      ar: 'الكأس يفوز'
    },
    tourNum: {
      en: 'Number of tournaments',
      ru: 'Количество турниров',
      ar: 'عدد البطولات'
    },
    active: {
      en: 'Active',
      ru: 'Активных',
      ar: 'قوي'
    },
    finished: {
      en: 'Finished',
      ru: 'Законченых',
      ar: 'ممتلىء'
    },
    notStart: {
      en: 'Not started',
      ru: 'Не начавшихся',
      ar: 'لا تبدأ'
    }
  },
  createText = {
    ...header,
    tourName: {
      en: 'Name of tournament',
      ru: 'Название турнира',
      ar: 'اسم البطولة'
    }, tourDescr: {
      en: 'Tournament description',
      ru: 'Описание турнира',
      ar: 'وصف البطولة'
    }, mode: {
      en: 'Mode',
      ru: 'Режим',
      ar: 'الوضع'
    },
    modeCup: {
      en: 'cup',
      ru: 'кубок',
      ar: 'فنجان'
    },
    place: {
      en: 'Place',
      ru: 'Место',
      ar: 'مكان'
    }, startDate: {
      en: 'Start date',
      ru: 'Дата начала',
      ar: 'تاريخ البداية'
    },
    lastDate: {
      en: 'Last registration date',
      ru: 'Дата конца регистрации',
      ar: 'تاريخ انتهاء التسجيل'
    },
    lvl: {
      en: 'Level of tournament',
      ru: 'Уровень турнира',
      ar: 'مستوى البطولة'
    }, advanced: {
      en: 'advanced',
      ru: 'продвинутый',
      ar: 'متطور'
    }, middle: {
      en: 'middle',
      ru: 'средний',
      ar: 'مركز'
    }, begginer: {
      en: 'begginer',
      ru: 'начальный',
      ar: 'ابتدائي'
    }, participants: {
      en: 'Number of participants',
      ru: 'Кол-во участников',
      ar: 'عدد المشاركين'
    },
    scenario: {
      en: 'Scenario',
      ru: 'Сценарий',
      ar: 'سيناريو'
    },
    one: {
      en: 'one-match confrontation',
      ru: 'одна игра',
      ar: 'لعبة واحدة'
    },
    two: {
      en: 'two-match confrontation',
      ru: 'две игры',
      ar: 'لعبتين'
    },
    create: {
      en: 'Create',
      ru: 'Создать',
      ar: 'يخلق'
    }
  },
  createIpt = {
    tourNameIpt: {
      en: 'Enter the cup name...',
      ru: 'Введите название кубка...',
      ar: 'أدخل اسم الكأس'
    }, tourDescrIpt: {
      en: 'Enter the cup description...',
      ru: 'Введите описание',
      ar: 'أدخل وصفًا'
    }, placeIpt: {
      en: 'Enter the cup location...',
      ru: 'Введите место проведения',
      ar: 'إدخال الدولة'
    }
  },
  settingModal = {
    modalHead: {
      en: 'My account',
      ru: 'Мой аккаунт',
      ar: 'الحساب'
    }, modalDescr: {
      en: 'Below you can change your login and/or password',
      ru: 'Ниже вы можете изменить и/или пароль',
      ar: 'أدناه يمكنك تغيير و / أو كلمة المرور'
    }, modalLogin: {
      en: 'Login',
      ru: 'Логин',
      ar: 'ليأتي'
    }, modalPassword: {
      en: 'Password',
      ru: 'Пароль',
      ar: 'كلمه السر'
    }, confirmModal: {
      en: 'Confirm password',
      ru: 'Подтвердить пароль',
      ar: 'تأكيد كلمة المرور'
    }, ok: {
      en: 'OK',
      ru: 'ОК',
      ar: 'بلى'
    }, modalCancel: {
      en: 'Cancel',
      ru: 'Отмена',
      ar: 'إلغاء'
    },
  },
  settingIpt = {
    modalLoginIpt: {
      en: 'Enter your new login...',
      ru: 'Введите новый логин',
      ar: 'أدخل اسم مستخدم جديد'
    }, modalPasswordIpt: {
      en: 'Enter your new password...',
      ru: 'Введите новый пароль',
      ar: 'أدخل كلمة مرور جديدة'
    }, confirmModalIpt: {
      en: 'Repeat password...',
      ru: 'Повторите пароль',
      ar: 'اعد كلمة السر'
    },
  },
  deleteModal = {
    ok: {
      en: 'OK',
      ru: 'ОК',
      ar: 'بلى'
    },
    modalCancel: {
      en: 'Cancel',
      ru: 'Отмена',
      ar: 'إلغاء'
    }, modalClear: {
      en: 'Clear All',
      ru: 'Удалить все',
      ar: 'احذف كل شيء'
    }, sure: {
      en: 'Are you sure you want to delete<br> all data?',
      ru: 'Вы уверенны что хотите удалить все данные',
      ar: 'هل أنت متأكد أنك تريد حذف بياناتك؟'
    },
  };

