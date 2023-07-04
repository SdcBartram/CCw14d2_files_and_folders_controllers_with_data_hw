package com.bartram.files_and_folders.other;

import com.bartram.files_and_folders.models.File;
import com.bartram.files_and_folders.models.Folder;
import com.bartram.files_and_folders.models.Person;
import com.bartram.files_and_folders.repositories.FileRepository;
import com.bartram.files_and_folders.repositories.FolderRepository;
import com.bartram.files_and_folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Person bob = new Person("Bob Bobbi");
        personRepository.save(bob);

        Person rob = new Person("Rob Robster");
        personRepository.save(rob);

        Person mel = new Person("Mel Shmell");
        personRepository.save(mel);


        Folder documents = new Folder("Documents", bob);
        folderRepository.save(documents);

        Folder pictures = new Folder("Pictures", rob);
        folderRepository.save(pictures);

        Folder downloads = new Folder("Downloads", mel);
        folderRepository.save(downloads);


        File file1 = new File("WordDoc1", ".doc", 1, documents);
        fileRepository.save(file1);

        File file2 = new File("Picture1", ".jpeg", 2, pictures);
        fileRepository.save(file2);

        File file3 = new File("Video1", ".mp4", 9, downloads);
        fileRepository.save(file3);
    }
}
