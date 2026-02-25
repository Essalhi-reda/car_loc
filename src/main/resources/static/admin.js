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