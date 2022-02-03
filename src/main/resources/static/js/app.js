const movie = document.getElementById('movie');
const fName = document.getElementById('fName');
const lName = document.getElementById('lName');
const mail = document.getElementById('mail');
const tel = document.getElementById('tel');
const num = document.getElementById('num');

const regTickets = async e => {
  e.preventDefault();
  try {
    const ticket = {
      movie: movie.value,
      fName: fName.value,
      lName: lName.value,
      mail: mail.value,
      tel: tel.value,
      num: num.value,
    };

    await fetch('/api/save', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(ticket),
    });

    await getAll();
    resetValues();
  } catch (error) {
    console.error(error);
  }
};

const getAll = async () => {
  try {
    const response = await fetch('/api/tickets');
    const data = await response.json();
    formatData(data);
  } catch (error) {
    console.error(error);
  }
};

const formatData = customers => {
  resetMessage();
  for (const customer of customers) {
    message.innerHTML += /*html*/ `
      <div style="margin: 1rem 0;">
        <p>Film: ${customer.movie}<p/>
        <p>Antall: ${customer.num}<p/>
        <p>Fornavn: ${customer.fName}<p/>
        <p>Etternavn: ${customer.lName}<p/>
        <p>Telefon: ${customer.tel}<p/>
        <p>Mail: ${customer.mail}<p/>
      </div>
      `;
  }
};

const delTickets = async () => {
  try {
    await fetch('/api/delete', {
      method: 'DELETE',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
    });
    await getAll();
    resetMessage();
    resetValues();
  } catch (error) {
    console.error(error);
  }
};

const resetValues = () => {
  movie.value = '';
  fName.value = '';
  lName.value = '';
  mail.value = '';
  tel.value = '';
  num.value = '';
};

const resetMessage = () => (message.innerHTML = '');

const message = document.getElementById('output');
const form = document.querySelector('form');
form.addEventListener('submit', regTickets);
form.addEventListener('reset', delTickets);
