package net.iesmaestrojuancalero.gesties.backend.data.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class AuthorSeederDev {

    @Autowired
    public AuthorSeederDev(AuthorSeeder authorSeeder) {
        authorSeeder.deleteAllAndInitializeAndSeedDataBase();
    }

}
