import React, { ChangeEvent, FormEvent, useState } from 'react'
import { VehiculesModel } from '../../model/VehiculeModel'

interface Props {
    data: VehiculesModel,
    delete: (id: number) => void,
    changeEdit: () => void,
    editLocataire: (locataire: VehiculesModel) => void
}

export const ListEditV = (props: Props) => {

    const [vehicule, setVehicule] = useState<VehiculesModel>(props.data)

    /**
     * Change la valeur d'une clé dans la state vehicule 
     * @param event 
     */
    const handleChange = (event : ChangeEvent<HTMLInputElement>) => {
        setVehicule({...vehicule, [event.target.name] : event.target.value});
    } 

    /**
     * Change la disponibilité du véhicule
     * @param event 
     */
    const handleChangeDispo = (event : ChangeEvent<HTMLInputElement>) => {
        setVehicule({...vehicule, available : event.target.checked})
    }

    /**
     * appelle la méthode delete du parents avec un id en parametre
     */
    const deleteLocataire = (id: number) => {
        props.delete(id);
    }

    /**
     * Modifie la valeur de la state locataire du parent
     * Puis appelle la methode changeEdit du parent
     * @param event 
     */
    const handleSubmit = (event: FormEvent<HTMLButtonElement>) => {
        event.preventDefault();
        props.editLocataire(vehicule);
        props.changeEdit();
    }

    return (
        <>
            <div>
                <p>modele: <input name='modele' onChange={(event) => handleChange(event)} type="text" value={vehicule.model}/></p>
                <p>Prix: <input name='prix' onChange={(event) => handleChange(event)} type="text" value={vehicule.price}/></p>
            </div>
            <div>
                <p>Immatriculation : <input name='immatriculation' onChange={(event) => handleChange(event)} type="text" value={vehicule.licenseNumber} /></p>
                <p>Etat : <input name='etat' onChange={(event) => handleChange(event)} type="text" value={vehicule.state} /></p>
                <p>Type : <input name='type' onChange={(event) => handleChange(event)} type="text" value={vehicule.type} /></p>
                <p>Marque : <input name='marque' onChange={(event) => handleChange(event)} type="text" value={vehicule.brand} /></p>
                <p>disponible: <input name='disponible' onChange={(event) => handleChangeDispo(event)} type="checkbox" checked={vehicule.available} /></p>
            </div>
            <div>
                <button onClick={() => deleteLocataire(props.data.id)}>Supprimer</button>
                <button onClick={(event) => handleSubmit(event)}>Modifier</button>
            </div>
        </>
    )
}
