package by.church4u.database.dao.interfaces;

import java.util.List;

import by.church4u.database.model.Profile;

public interface ProfileDAO
{

    /**
     * Add a new profile
     *
     * @param aProfile
     */
    public Profile addProfile(final Profile aProfile);

    /**
     * get profile
     *
     * @param anId
     */
    public Profile getProfile(final long anId);

    /**
     * get all profile
     */
    public List<Profile> getAllProfile();

    /**
     * delete profile
     *
     * @param anId
     */
    public void deleteProfile(final long anId);

    /**
     * edit profile
     *
     * @param aProfile
     */
    public Profile editProfile(final Profile aProfile);
}