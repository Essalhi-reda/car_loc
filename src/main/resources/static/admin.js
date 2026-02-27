window.onload = function() {
    affichervoitures();
}


document.getElementById("carForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const voiture = {
        brand: document.getElementById("brand").value,
        model: document.getElementById("model").value,
        pricePerDay: parseInt(document.getElementById("price").value),
        status: document.getElementById("status").value,
        imageUrl: document.getElementById("imageUrl").value
    };

    fetch("/cars", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(voiture)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur serveur");
            }
            return response.json();
        })
        .then(data => {
            alert("Voiture ajoutée ✅");
            document.getElementById("carForm").reset();
        })
        .catch(error => {
            alert("Erreur ❌");
            console.error(error);
        });
});


function affichervoitures() {

    fetch("/cars")
        .then(response => response.json())
        .then(data => {

            let table = document.getElementById("carsTable");

            data.forEach(car => {

                let row = document.createElement("tr");

                row.innerHTML = `
                    <td>${car.id}</td>
                    
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.pricePerDay}</td>
                    <td>${car.status}</td>
                    <td>${car.imageUrl}</td>
                `;

                table.appendChild(row);
            });
        });
}


