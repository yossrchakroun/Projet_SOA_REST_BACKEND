<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Gestion Campus - Reservations</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- HEADER -->
<div class="bg-gradient text-white text-center py-4 shadow-sm" style="background: linear-gradient(135deg, #5B51D8, #7B68EE);">
  <h1 class="display-5 fw-bold" style = "color : blue">Gestion de Campus</h1>
  <p class="lead" style = "color : blue">Systeme de Reservation</p>
</div>

<!-- ONGLET -->
<div class="container my-4">
  <ul class="nav nav-pills justify-content-center gap-3 mb-5">
    <li class="nav-item"><a class="nav-link active px-5 py-3 rounded-pill" data-tab="chambres">Chambres</a></li>
    <li class="nav-item"><a class="nav-link  px-5 py-3 rounded-pill" data-tab="clients">Clients</a></li>
    <li class="nav-item"><a class="nav-link  px-5 py-3 rounded-pill" data-tab="reservations">Réservations</a></li>
  </ul>

  <!-- CONTENU -->
  <div id="content" class="card shadow-lg border-0">
    <div class="card-body p-5">
      <h2 class="text-center text-primary mb-4">Gestion des Chambres</h2>
      <div class="row g-4">
        <div class="col-md-6">
          <div class="input-group">
            <span class="input-group-text bg-primary text-white"><i class="fas fa-hashtag"></i></span>
            <input type="text" class="form-control form-control-lg" placeholder="Numero (ex: 101)" id="numero">
          </div>
        </div>
        <div class="col-md-6">
          <div class="input-group">
            <span class="input-group-text bg-primary text-white"><i class="fas fa-bed"></i></span>
            <select class="form-select form-select-lg" id="type">
              <option>Type de chambre</option>
              <option>Simple</option>
              <option>Double</option>
              <option>triple</option>
              <option>reunion</option>
              <option>evenement</option>
              <option>studio</option>


            </select>
          </div>
        </div>
        <div class="col-md-4">
          <div class="input-group">
            <span class="input-group-text bg-primary text-white"><i class="fas fa-users"></i></span>
            <input type="number" class="form-control form-control-lg" placeholder="Capacite" id="capacite">
          </div>
        </div>
        <div class="col-md-4">
          <div class="input-group">
            <span class="input-group-text bg-primary text-white"><i class="fas fa-euro-sign"></i></span>
            <input type="number" class="form-control form-control-lg" placeholder="Prix/jour" id="prix">
          </div>
        </div>
        <div class="col-md-4">
          <div class="input-group">
            <span class="input-group-text bg-primary text-white"><i class="fas fa-circle-check"></i></span>
            <select class="form-select form-select-lg" id="statut">
              <option>etat de chambre</option>
              <option>disponible</option>
              <option>occupee</option>
              <option>maintenance</option>

            </select>
          </div>
        </div>
        <div class="col-12">
          <div class="input-group">
            <span class="input-group-text bg-primary text-white"><i class="fas fa-wifi"></i></span>
            <input type="text" class="form-control form-control-lg" placeholder="equipements (WiFi, TV...)" id="equipements">
          </div>
        </div>
        <div class="col-12">
                  <div class="input-group">
                    <span class="input-group-text bg-primary text-white"><i></i></span>
                    <input type="text" class="form-control form-control-lg" placeholder="description" id="description">
                  </div>
                </div>
        <div class="col-12 text-center mt-4">
          <button class="btn btn-success btn-lg px-5 mx-2 shadow"><i class="fas fa-plus"></i> Ajouter</button>
          <button class="btn btn-warning btn-lg px-5 mx-2 shadow text-white"><i class="fas fa-edit"></i> Modifier</button>
          <button class="btn btn-danger btn-lg px-5 mx-2 shadow"><i class="fas fa-trash"></i> Supprimer</button>
          <button class="btn btn-info btn-lg px-5 mx-2 shadow text-white"><i class="fas fa-sync"></i> Actualiser</button>
        </div>
      </div>

      <hr class="my-5">

      <h4 class="text-center text-secondary">Liste des Chambres</h4>
      <div class="table-responsive mt-3">
        <table class="table table-hover align-middle">
          <thead class="table-primary">
            <tr>
              <th>ID</th><th>Numero</th><th>Type</th><th>Capacite</th><th>Prix/jour</th><th>Statut</th><th>equipements</th><th>Action</th>
            </tr>
          </thead>
          <tbody id="tableau">
            <!-- rempli par JS -->
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<script src="js/app.js"></script>
</body>
</html>