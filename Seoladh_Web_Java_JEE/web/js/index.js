<script type="text/javascript">
    window.onload = function () {
        console.log('Le fichier a bien été chargé : '+new Date()+'.');

        // Variables contantes
        modeDebugg = true;
        modulesActifs = 0;
        modulesUrlDevLdumayHost = 'https://dev.ldumay.fr/toolkits';
        modulesDevLdumayFolder = 'js';
        modulesDevLdumayFolderPlugins = 'plugins';
        modulesUrlHostGoogleLib = 'https://ajax.googleapis.com';
        modulesUrlHostLinkedIn = 'https://platform.linkedin.com';
        // Versions des paquets Javascript et JQuery nécessaires
        moduleVersionBootstrap = '4.1.3';
        moduleVersionJQueryLdumay = '1.11.3';
        moduleVersionJQueryGoogle = '1.12.4';
        // Versions des plugins Javascript et JQuery
        moduleVersionChart = '1.0.2';
        moduleVerionStickykit = '1.1.2';

        // Imports de tous les modules disponibles et nécessaires
        // Création des liens des paquets Javascript et JQuery nécessaires
        // -> LDumay - Boostrap
        moduleBootstrap = modulesUrlDevLdumayHost+'/bootstrap/'+moduleVersionBootstrap+'/'+modulesDevLdumayFolder+'/bootstrap.min.js'; import(moduleBootstrap);
        if(modeDebugg==true){ console.log('Le module "moduleBootstrap" est chargé.\nLe lien est : '+moduleBootstrap); modulesActifs++; }
        // -> LDumay - Jquery 
        moduleJQueryLDumay = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/jquery/'+moduleVersionJQueryLdumay+'/jquery.min.js'; import(moduleJQueryLDumay);
        if(modeDebugg==true){ console.log('Le module "moduleJQueryLDumay" est chargé.\nLe lien est : '+moduleJQueryLDumay); modulesActifs++; }
        // -> Google - Jquery
        moduleJQueryGoogle = modulesUrlHostGoogleLib+'/ajax/libs/jquery/'+moduleVersionJQueryGoogle+'/jquery.min.js'; import(moduleJQueryGoogle);
        if(modeDebugg==true){ console.log('Le module "moduleJQueryGoogle" est chargé.\nLe lien est : '+moduleJQueryGoogle); modulesActifs++; }
        // -> LDumay - Modernizr
        moduleModernizr = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/modernizr/3.3.1/modernizr.min.js'; import(moduleModernizr);
        if(modeDebugg==true){ console.log('Le module "moduleModernizr" est chargé.\nLe lien est : '+moduleModernizr); modulesActifs++; }
        // -> LDumay - LinkedInScript
        moduleLinkedInBadge = modulesUrlHostLinkedIn+'/badges/js/profile.js'; import(moduleLinkedInBadge);
        if(modeDebugg==true){ console.log('Le module "moduleLinkedInBadge" est chargé.\nLe lien est : '+moduleLinkedInBadge); modulesActifs++; }

        // Création des liens des plugins Javascript et JQuery
        // -> LDumay - Typed
        moduleTyped = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/'+modulesDevLdumayFolderPlugins+'/typed/typed.min.js'; import(moduleTyped);
        if(modeDebugg==true){ console.log('Le module "moduleTyped" est chargé.\nLe lien est : '+moduleTyped); modulesActifs++; }
        // -> LDumay - Mixitup
        moduleMixitup = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/'+modulesDevLdumayFolderPlugins+'/mixitup/jquery.mixitup.js'; import(moduleMixitup);
        if(modeDebugg==true){ console.log('Le module "moduleMixitup" est chargé.\nLe lien est : '+moduleMixitup); modulesActifs++; }
        // -> LDumay - VerticalTimeline
        moduleVerticalTimeline = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/'+modulesDevLdumayFolderPlugins+'/vertical-timeline/vertical-timeline-modernizr.js'; import(moduleVerticalTimeline);
        if(modeDebugg==true){ console.log('Le module "moduleVerticalTimeline" est chargé.\nLe lien est : '+moduleVerticalTimeline); modulesActifs++; }
        // -> LDumay - Chart
        moduleChart = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/'+modulesDevLdumayFolderPlugins+'/chart/'+moduleVersionChart+'/chart.min.js'; import(moduleChart);
        if(modeDebugg==true){ console.log('Le module "moduleChart" est chargé.\nLe lien est : '+moduleChart); modulesActifs++; }
        // -> LDumay - Stickykit
        moduleStickykit = modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'/sticky-kit/'+moduleVerionStickykit+'/sticky-kit.min.js'; import(moduleStickykit);
        if(modeDebugg==true){ console.log('Le module "moduleStickykit" est chargé.\nLe lien est : '+moduleStickykit); modulesActifs++; }

        if(modeDebugg==true){ console.log('Le nombre total de module activé est de :'+modulesActifs); }

        console.log('Les imports ont bien été chargé. Il y en a : '+modulesActifs);
    };
    
    /*
    // -> LDumay - Typist
    module = require(modulesUrlDevLdumayHost+'/'+modulesDevLdumayFolder+'');
    if(modeDebugg==true){ console.log('Le module "_module_" est chargé.\nLe lien est : '+_module_); modulesActifs++; }
    */

    /*
    // JS Test Functions for Devlopper
    function displaySize(){
        var display_width = $(window).width();
        var display_height = $(window).height();
        message = 'Function - displaySize() - Done !';
        alert('Display Size.\n\nWidth : ' + display_width + '\nHeight :' + display_height + '\n\n' + message);
        return console.log(message);

    }
    // Display an alert message and return a console message.
    */

    /*
    // VerticalTimeline - Main
    jQuery(document).ready(function($){
        var timelineBlocks = $('.cd-timeline-block'),
            offset = 0.8;

        //hide timeline blocks which are outside the viewport
        hideBlocks(timelineBlocks, offset);

        //on scolling, show/animate timeline blocks when enter the viewport
        $(window).on('scroll', function(){
            (!window.requestAnimationFrame) 
                ? setTimeout(function(){ showBlocks(timelineBlocks, offset); }, 100)
                : window.requestAnimationFrame(function(){ showBlocks(timelineBlocks, offset); });
        });

        function hideBlocks(blocks, offset) {
            blocks.each(function(){
                ( $(this).offset().top > $(window).scrollTop()+$(window).height()*offset ) && $(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
            });
        }

        function showBlocks(blocks, offset) {
            blocks.each(function(){
                ( $(this).offset().top <= $(window).scrollTop()+$(window).height()*offset && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) && $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
            });
        }
    });
    */
</script>