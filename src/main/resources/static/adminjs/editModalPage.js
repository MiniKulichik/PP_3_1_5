const form_ed = document.getElementById('formForEditing');
const id_ed = document.getElementById('id_ed');
const name_ed = document.getElementById('name_ed');
const surname_ed = document.getElementById('surname_ed');
const age_ed = document.getElementById('age_ed');
const username_ed = document.getElementById('username_ed');
const password_ed = document.getElementById('password_ed');


async function editModalData(id) {

    $('#editModal').modal('show');
    const urlDataEd = 'api/admin/users/' + id;
    let usersPageEd = await fetch(urlDataEd);

    if (usersPageEd.ok) {
        let userData =
            await usersPageEd.json().then(user => {
                id_ed.value = `${user.id}`;
                name_ed.value = `${user.name}`;
                surname_ed.value = `${user.surname}`;
                age_ed.value = `${user.age}`;
                username_ed.value = `${user.username}`;
                password_ed.value = `${user.password}`;
            })
    } else {
        alert(`Error, ${usersPageEd.status}`)
    }
}

async function editUser() {

    let urlEdit = 'api/admin/users/' + id_ed.value;
    let listOfRole = [];
    for (let i = 0; i < form_ed.rolesForEditing.options.length; i++) {
        if (form_ed.rolesForEditing.options[i].selected) {
            listOfRole.push("ROLE_" + form_ed.rolesForEditing.options[i].value);
        }
    }

    let method = {

        method: 'PATCH',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: form_ed.name.value,
            lastname: form_ed.surname.value,
            age: form_ed.age.value,
            email: form_ed.username.value,
            password: form_ed.password.value,
            roles: listOfRole
        })
    }

    await fetch(urlEdit, method).then(() => {
        $('#editCloseBtn').click();
        getAdminPage();
    })
}