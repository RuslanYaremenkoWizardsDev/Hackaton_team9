
export const modal = `
    <div class="header__modal">
      <div class="header__modal-content">
        <div class="header__modal-head">
          <p class="header__head-text">My account</p>
          <span class="header__close">&times;</span>
        </div>
        <div class="header__avatar">
          <img src="../../assets/1-36-1024x1024.jpg" class="header__modal-avatar">
          <div class="header__avatar-add">+</div>
        </div>
        <p class="header__modal-text">Below you can change your login and/or password</p>
        <div class="header__login">
           <p class="header__input-text">Login</p>
          <div class="header__login-box">
            <input class="header__input" placeholder="Enter your new login...">
             <input class="header__checkbox" type="checkbox">
          </div>
        </div>
        <div class="header__password">
          <p class="header__input-text">Password</p>
          <div class="header__password-box">
            <input class="header__input" placeholder="Enter your new password...">
            <input class="header__checkbox" type="checkbox">
          </div>
          <p class="header__input-text">Confirm password</p>
          <input class="header__input" placeholder="Repeat password...">
        </div>
        <div class="header__modal-buttons">
          <div class="header__ok btn">OK</div>
          <div class="header__cancel btn">Cancel</div>
        </div>
      </div>
    </div>`;

export const modalDelete = `
  <div class="tableTop__modal">
    <div class="tableTop__modal-content">
      <div class="tableTop__heder-box">
        <p class="tableTop__header-text">Clear all</p>
        <span class="tableTop__close">&times;</span>
      </div>
      <p class="tableTop__text">Are you sure you want to delete<br> all data?</p>
      <div class="tableTop__buttons">
        <div class="tableTop__ok btn">OK</div>
        <div class="tableTop__cancel btn">Cancel</div>
      </div>
    </div>
  </div>`;